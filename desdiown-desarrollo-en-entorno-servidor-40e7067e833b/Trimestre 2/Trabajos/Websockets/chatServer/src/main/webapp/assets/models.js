function Message(user,save,msg,propagate)
{
    this.sender = user;
    this.save = save;
    this.mensaje = msg;
    this.propagate = propagate;
}
function User(id, email, pass, token, type)
{
    this.id = id;
    this.email = email;
    this.pass = pass;
    this.token = token;
    this.type = type;
}
function Data(type,data)
{
    this.type = type;
    this.data = JSON.stringify(data);
}
function FilterDates(beginDate,endDate)
{
    this.beginDate = beginDate;
    this.endDate = endDate;
}
function Channel(id,name,admin_id,password)
{
    this.id = id;
    this.name = name;
    this.admin_id = admin_id;
    this.password = password;
}
function ChannelPermissions(askingUser, adminUser, channel, granted)
{
    this.askingUser = askingUser;
    this.adminUser = adminUser;
    this.channel = channel;
    this.granted = granted;
}