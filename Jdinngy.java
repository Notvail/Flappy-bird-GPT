const canvas = document.getElementById("flappyBirdCanvas");
const ctx = canvas.getContext("2d");

// Bird
let birdY = canvas.height / 2;
let birdVelocity = 0;
const gravity = 0.5;

// Pipes
const pipeWidth = 50;
const pipeHeight = canvas.height - 100;
let pipeX = canvas.width;
let pipeGap = 150;

function drawBird() {
  ctx.fillStyle = "#FF5733";
  ctx.fillRect(50, birdY - 15, 30, 30);
}

function drawPipe() {
  ctx.fillStyle = "#5CACEE";
  ctx.fillRect(pipeX, 0, pipeWidth, pipeHeight);
  ctx.fillRect(pipeX, pipeHeight + pipeGap, pipeWidth, canvas.height - pipeHeight - pipeGap);
}

function gameLoop() {
  // Update
  birdVelocity += gravity;
  birdY += birdVelocity;
  pipeX -= 5;

  // Draw
  ctx.clearRect(0, 0, canvas.width, canvas.height);
  drawBird();
  drawPipe();

  // Request next frame
  requestAnimationFrame(gameLoop);
}

// Start the game loop
gameLoop();
