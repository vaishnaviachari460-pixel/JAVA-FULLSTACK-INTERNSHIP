//CALBACK PRACTICE

function processNumber(num, callback) {
    let result = num * 2;   // double the number
    callback(result);       // pass to callback
}

function printResult(res) {
    console.log("Result:", res);
}

// call function
processNumber(5, printResult);


//PROMISE PRACTICE

let checkNumber = new Promise((resolve, reject) => {
    let num = 8; // change value to test

    if (num > 10) {
        resolve("Success");
    } else {
        reject("Fail");
    }
});

checkNumber
    .then((res) => {
        console.log(res);
    })
    .catch((err) => {
        console.log(err);
    });

//ASYNC/AWAIT PRACTICE

// Define first
function getData() {
    return new Promise((resolve, reject) => {
        let success = true; // change to test

        if (success) {
            resolve("Data received");
        } else {
            reject("Error occurred");
        }
    });
}

// ASYNC/AWAIT
async function fetchData() {
    try {
        let res = await getData();
        console.log(res);
    } catch (error) {
        console.log("Something went wrong");
    }
}

fetchData();


//ERROR HANDLING PRACTICE

function getData() {
    return new Promise((resolve, reject) => {
        let success = false;

        if (success) {
            resolve("Data received");
        } else {
            reject("Error occurred");
        }
    });
}

async function handleData() {
    try {
        let result = await getData();
        console.log(result);
    } catch (error) {
        console.log("Something went wrong");
    }
}

handleData();


//FETCH API PRACTICE
fetch("https://jsonplaceholder.typicode.com/posts")
    .then((response) => response.json())
    .then((data) => {
        data.forEach((post) => {
            console.log(post.title);
        });
    })
    .catch((error) => {
        console.log("Error:", error);
    });