//SIMPLE GREETING CALLBACK

function greetUser(name, callback) {
    callback(name);
}

function sayHello(name) {
    console.log("Hello " + name + "!");
}

// Call function
greetUser("Vaishnavi", sayHello);


//CALCULATOR WITH CALLBACK

function calculate(a, b, operation, callback) {
    let result;

    if (operation === "add") {
        result = a + b;
    } else if (operation === "sub") {
        result = a - b;
    } else if (operation === "mul") {
        result = a * b;
    } else if (operation === "div") {
        result = a / b;
    }

    callback(result);
}

function displayResult(result) {
    console.log("Result is: " + result);
}

// Call function
calculate(10, 5, "add", displayResult);


//DELAY MESSAGE WITH CALLBACK

function delayMessage(message, callback) {
    console.log("Please wait...");

    setTimeout(() => {
        callback(message);
    }, 3000);
}

function showMessage(msg) {
    console.log(msg);
}

// Call function
delayMessage("This is a delayed message!", showMessage);