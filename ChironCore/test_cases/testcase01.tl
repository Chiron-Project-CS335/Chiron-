to square(:size) [
  output :size * :size
] end

:result = square(5)
forward :result
