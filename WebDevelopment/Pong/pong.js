 
function Paddle(x) {
    this.x = x;
    this.y = 250;
}


Paddle.prototype = {
    'draw': function(ctx) {
        ctx.fillStyle = 'white';
        ctx.fillRect(this.x, this.y - 50, 25, 100);
    },
    inside: function(x, y) {
        return (x >= this.x && x<= this.x +25 && y  > this.y - 50 && y < this.y + 50);
    },
};



function Ball(x, y, dx, dy) {
    this.x = x;
    this.y = y;
    this.dx = dx;
    this.dy = dy;
}

Ball.prototype = {
        'draw' : function (ctx) {
            ctx.fillStyle = 'blue':
            ctx.fillRect(this.x-10, this.y - 10, 20, 20);
        },
        'tick': function() {
            this.x += this.dx;
            this.y += this.dy;
            var topLeft = leftPaddle.inside(this.x - 10, this.y - 10);
            var bottomLeft = leftPaddle.inside(this.x - 10, this.y + 10);
            if (topLeft || bottomLeft) {
                this.dx = -this.dx;
                if (topLeft && !bottomLeft) {
                    this.dy += 5;
                }
                if (bottomLeft && !topLeft) {
                    this.dy -= 5;
                }
                score++;
                var s = document.getElementById('score');
                var tn = document.createTextNode(score);
                s.removeChild(s.lastChild);
                s.appendChild(tn);
            }
            if (this.x > 490) {
                this.dx = -this.dx;
            }
            if (this.y > 490) {
                this.dy = -this.dy;
            }
            if (this.y < 10) {
                this.dy = -this.dy;
            }
            if (this.x < 0) {
                this.x = 250;
                this.y = 250;
                this.dx = 5 + Math.random() * 5;
                if (Math.random() < 0.5) 
                    this.dx = -this.dx;
                this.dy = Math.random() * 10 - 5;
            }
    },
}


function draw() {
    var area = document.getElementById('area');
    var ctx = area.getContext('2d');
    ctx.fillStyle = 'grey';
    ctx.fillRect(0,0, 500, 500);
    ball.draw(ctx);
}
    
    
    
var leftPaddle;
var ball;
var score = 0;
    

function handleMouseMove(ev) {
    leftPaddle.y = ev.offsetY;
    draw();
}


function update() {
    ball.tick();
    draw();
}


window.addEventListener("load", function() {
    leftPaddle = new Paddle(1);
    ball = new Ball(250,250, -5 1);
    draw();
    document.getElementById('area').addEventListener('mousemove', handleMouseMove);
    var interval = window.setInterval(update, 150);
});