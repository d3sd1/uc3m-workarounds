package services;

import dao.CrudDAO;
import java.util.List;
import model.Car;


public class CrudService
{
    public List<Car> getAllCars()
    {
        CrudDAO dao = new CrudDAO();
        return dao.getAllCars();
    }
    public boolean insertCar(Car coche)
    {
        CrudDAO dao = new CrudDAO();
        return dao.insertCar(coche);
    }
    public boolean updateCar(Car coche)
    {
        CrudDAO dao = new CrudDAO();
        return dao.updateCar(coche);
    }
    public boolean deleteCar(Car coche)
    {
        CrudDAO dao = new CrudDAO();
        return dao.deleteCar(coche);
    }
}
