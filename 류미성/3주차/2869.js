let fs = require("fs");
let input = fs
	.readFileSync("/dev/stdin")
	.toString()
	.split(" ")
	.map((el) => +el);

let climb = input[0];
let slipped = input[1];
let height = input[2];

let day = Math.ceil((height - slipped) / (climb - slipped));

console.log(day);
