to drawSquare(:size) [
  repeat 4 [
    forward :size
    right 90
  ]
]
end

to square(:size) [
  output :size * :size
]
end

drawSquare(50)
:area = square(10)

:x = drawSquare(20)
square(15)
