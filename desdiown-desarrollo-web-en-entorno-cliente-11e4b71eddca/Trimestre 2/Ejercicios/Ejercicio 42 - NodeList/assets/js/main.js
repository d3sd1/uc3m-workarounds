var lastPos = 0,
menu = document.getElementById("navigation");

window.onload = function() {
	init();
};
function init()
{
	var nodeList = document.querySelectorAll("p");
	alert(nodeList);
	console.log("Longitud nodelist: " + nodeList.length);
	console.log("Primer nodo: " + nodeList[0]);
}