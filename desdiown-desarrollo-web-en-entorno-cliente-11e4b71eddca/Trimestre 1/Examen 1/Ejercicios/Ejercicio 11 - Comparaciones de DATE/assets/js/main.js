var fecha1 = prompt("Introduce la fecha 1 en formato dd-mm-YYYY", "16-10-2017"),
	fecha2 = prompt("Introduce la fecha 2 en formato dd-mm-YYYY", "16-12-2017"),
	fecha1Info = fecha1.split("-"),
	fecha1Date = new Date(parseInt(fecha1Info[2]),(parseInt(fecha1Info[1])-1),parseInt(fecha1Info[0]),0,0,0,0),
	fecha2Info = fecha2.split("-"),
	fecha2Date = new Date(parseInt(fecha2Info[2]),parseInt(fecha2Info[1])-1,parseInt(fecha2Info[0]),0,0,0,0);
document.write("Fecha 1: " + fecha1Date + "<br>");
document.write("Fecha 2: " + fecha2Date + "<br>");
document.write("Segundos entre fechas: " + ((fecha2Date.getTime()-fecha1Date.getTime())/1000) + "<br>");