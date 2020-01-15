window.onload = function() {
	console.debug("call func");
	init();
};
function init()
{
	var attr = document.getElementById("par").attributes;
	/* ESTE DE ABAJO FUNCIONA */
	for(var i = 0; i < attr.length; i++)
	{
		console.log(attr[i].nodeName);
		console.log(attr[i].nodeType);
		console.log(attr[i].nodeValue);
		console.log("---------------");
	}
	
	/* ESTE ES LO MISMO, PERO NO FUNCIONA */
	for(var attr in document.getElementById("par").attributes)
	{
		console.log(attr.nodeName);
	}
}