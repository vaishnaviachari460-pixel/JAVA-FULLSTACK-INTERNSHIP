
//CHANGE TEXT
function changeText() {
    document.getElementById("text").innerText = "Text Changed!";
}

//CHANGE COLOR
function changeColor() {
    document.body.style.backgroundColor = "lightblue";
}


//SHOW INPUT
function showValue() {
    let value = document.getElementById("userInput").value;
    document.getElementById("result").innerText = value;
}