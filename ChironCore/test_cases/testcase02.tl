to factorial(:n) [
  if :n <= 1 [
    output 1
  ] else [
    :t = :n * factorial(:n - 1)
    output :t
  ]
] end

:result = factorial(3)
forward :result
