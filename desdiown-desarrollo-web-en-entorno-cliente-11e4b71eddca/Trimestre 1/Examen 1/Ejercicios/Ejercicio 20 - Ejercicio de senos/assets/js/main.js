var actualNumRadians = 0,interv;

function stopInterval()
{
	clearInterval(interv);
}
function startInterval()
{
	interv = setInterval(showSin,1000);
}
function toRadians (angle) {
	return angle * (Math.PI / 180);
}
function showSin()
{
	console.log("SENO DE " + actualNumRadians + " grados = " + 
					(Math.round(
								Math.sin(
										toRadians(actualNumRadians)
										)
								*100)
					/100).toFixed(2)
				);
	console.log("COSENO DE " + actualNumRadians + " grados = " + 
					(Math.round(
								Math.cos(
										toRadians(actualNumRadians)
										)
								*100)
					/100).toFixed(2)
				);
	actualNumRadians++;
}
startInterval();