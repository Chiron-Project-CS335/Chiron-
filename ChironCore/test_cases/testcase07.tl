to fibonacci(:n) [
  if :n <= 1 [
    output :n
  ] else [
    output fibonacci(:n - 1) + fibonacci(:n - 2)
  ]
] end

:result = fibonacci(7)
forward :result
