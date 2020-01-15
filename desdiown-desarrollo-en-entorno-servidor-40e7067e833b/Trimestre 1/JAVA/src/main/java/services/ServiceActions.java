package services;

import ajax.AjaxMaker;
import ajax.AjaxResponse;
import dao.UsersSpringJDBC;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Map;
import model.User;
import org.springframework.dao.EmptyResultDataAccessException;
import utils.Common;
import utils.Constants;
import utils.PasswordHash;
import utils.SendMail;
import yml.ConfigGeneral;
import yml.ConfigMail;
import yml.ConfigSecurity;
import yml.Language;

public class ServiceActions
{

    private final AjaxMaker ajax = new AjaxMaker();

    public String doRegister(Map params)
    {
        AjaxResponse returnme;
        UsersSpringJDBC dao = new UsersSpringJDBC();
        /* Create Alumno */
        User user = new User();
        try
        {
            user.setNOMBRE(((String[]) params.get(Constants.PARAMETER_NAME_SENDNAME))[0]);
            user.setEMAIL(((String[]) params.get(Constants.PARAMETER_NAME_SENDEMAIL))[0]);

            String userPasswordPlain = ((String[]) params.get(Constants.PARAMETER_NAME_SENDPASS))[0];
            String hash = PasswordHash.getInstance().createHash(userPasswordPlain);
            user.setPASSWORD(hash);

        }
        catch (NoSuchAlgorithmException | InvalidKeySpecException ex)
        {
            
        }

        /* Database check and procedures */
        if (dao.findUserByEmail(user) == 0)
        {
            DateFormat dateFormat = new SimpleDateFormat(ConfigGeneral.getInstance().getDateFormat());
            Date date = new Date();
            user.setACTIVO(false);
            user.setFECHA_ACTIVACION(dateFormat.format(date));
            String activationCode = Common.randomAlphaNumeric(ConfigSecurity.getInstance().getSecurityLevel());
            user.setCODIGO_ACTIVACION(activationCode);
            long insertedID = dao.doRegister(user);
            if (insertedID != 0)
            {
                user.setID(insertedID);
                SendMail mail = new SendMail();
                mail.sendActivationCode(user.getEMAIL(), user.getCODIGO_ACTIVACION());
                returnme = ajax.successResponse();
            }
            else
            {
                returnme = ajax.errorResponse(Language.getInstance().getDbSqlQueryError());
            }
        }
        else
        {
            returnme = ajax.errorResponse(Language.getInstance().getUserMailDuplicatedError());
        }
        return ajax.parseResponse(returnme);
    }

    public AjaxResponse checkLogin(Map params)
    {
        AjaxResponse returnme;
        UsersSpringJDBC dao = new UsersSpringJDBC();
        User user = new User();
        try
        {
            user.setEMAIL(((String[]) params.get(Constants.PARAMETER_NAME_SENDEMAIL))[0]);

            String userPasswordPlain = ((String[]) params.get(Constants.PARAMETER_NAME_SENDPASS))[0];
            user.setPASSWORD(userPasswordPlain);

            User foundUser = dao.getUserByEmail(user);
            boolean validPass = PasswordHash.getInstance().validatePassword(user.getPASSWORD(), foundUser.getPASSWORD());
            if (validPass)
            {
                if (foundUser.isACTIVO())
                {
                    returnme = ajax.successResponse();
                }
                else
                {
                    returnme = ajax.errorResponse(Language.getInstance().getUserNotActiveError());
                }
            }
            else
            {
                returnme = ajax.errorResponse(Language.getInstance().getLoginError());
            }
        }
        catch (NoSuchAlgorithmException | InvalidKeySpecException | EmptyResultDataAccessException ex)
        {
            returnme = ajax.errorResponse(Language.getInstance().getLoginError());
        }
        catch (NullPointerException ex)
        {
            returnme = ajax.errorResponse(Language.getInstance().getNullPointerError());
        }
        catch (NumberFormatException ex)
        {
            returnme = ajax.errorResponse(Language.getInstance().getNumberFormatError());
        }
        return returnme;
    }

    public String doVerify(Map params)
    {
        AjaxResponse returnme;
        UsersSpringJDBC dao = new UsersSpringJDBC();
        User user = new User();
        try
        {
            user.setCODIGO_ACTIVACION(((String[]) params.get(Constants.PARAMETER_NAME_SENDCODE))[0]);
            User foundUser = dao.findUserByVerificationCode(user);
            if (dao.findUserCountByVerificationCode(user) > 0)
            {
                long minutesPassed = -1;
                try
                {
                    LocalDateTime now = LocalDateTime.now();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(ConfigGeneral.getInstance().getDateFormat() + ".S");
                    LocalDateTime activationDate = LocalDateTime.parse(foundUser.getFECHA_ACTIVACION(), formatter);

                    Duration duration = Duration.between(now, activationDate);
                    minutesPassed = Math.abs(duration.toMinutes());

                }
                catch (Exception ex)
                {
                    
                }

                if (minutesPassed <= ConfigMail.getInstance().getLimitActivationMins() && minutesPassed != -1)
                {
                    int updatedRows = dao.activateUser(user);
                    if (updatedRows > 0)
                    {
                        returnme = ajax.successResponse();
                    }
                    else
                    {
                        returnme = ajax.errorResponse(Language.getInstance().getUserActivateGenericError());
                    }
                }
                else if (minutesPassed == -1)
                {
                    returnme = ajax.errorResponse(Language.getInstance().getNumberFormatError());
                }
                else
                {
                    String activationCode = Common.randomAlphaNumeric(ConfigSecurity.getInstance().getSecurityLevel());
                    SendMail mail = new SendMail();
                    mail.sendActivationCode(user.getEMAIL(), user.getCODIGO_ACTIVACION());
                    returnme = ajax.errorResponse(Language.getInstance().getUserActivateExpiredError());
                }
            }
            else
            {
                returnme = ajax.errorResponse(Language.getInstance().getUserActivationFailError());
            }
        }
        catch (NullPointerException ex)
        {
            returnme = ajax.errorResponse(Language.getInstance().getNullPointerError());
        }
        catch (Exception ex)
        {
            returnme = ajax.errorResponse(Language.getInstance().getUserActivateGenericError());
        }
        return ajax.parseResponse(returnme);
    }
}
