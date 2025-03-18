to square :size [
  repeat 4 [
    forward :size
    right 90
  ]
  output :size * 4
  ]
end

to rectangle :length :width [
  forward :length
  right 90
  forward :width
  right 90
  forward :length
  right 90
  forward :width
  output 2 * (:length + :width)
  ]
end

:result = square 50
:perimeter = rectangle 100 50
