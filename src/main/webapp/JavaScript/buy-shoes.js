function render(amount){
	document.getElementById("amount").value = amount;
}


function handlePlus(){
	const amount = document.getElementById('amouont').value;
	amount++;
	render(amount);
	console.log(amount);
}

function handleMinus(){
	const amount = document.getElementById('amouont').value;
	if(amount > 1) amount--;
	render(amount);
}

