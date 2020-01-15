function eventaco(ev)
{
	if(window.event)
	{
		console.log("detecta windowevent");
		document.title = window.event.screenX + "x / " + window.event.screenY + "y";
	}
	else{
		console.log("NOO detecta windowevent");
		document.title = ev.windowX + "x / " + ev.windowY + "y";
	}
}
document.onmousemove=eventaco;