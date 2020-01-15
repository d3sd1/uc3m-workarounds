var nuevaventana;
function nuevaventana()
{
	nuevaventana = window.open("22.html","_blank","width: 100, height: 100");
}
function moverme()
{
	console.log("clicked");
	nuevaventana.moveTo(screen.width);
}

nuevaventana();
	nuevaventana.onclick = function(e) { 
    console.log("click");
};