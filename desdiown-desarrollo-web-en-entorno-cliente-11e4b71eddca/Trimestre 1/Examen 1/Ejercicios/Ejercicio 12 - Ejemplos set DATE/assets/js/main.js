var hoy = new Date(),
	mañana = new Date();
mañana.setTime(hoy.getTime() + (24*60*60*1000));
document.write(mañana);