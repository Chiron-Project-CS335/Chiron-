:global = 10

to adder(:x) [
  :local = 5
  :t = :x + :local + :global
  output :t
] end

:result = adder(3)
forward :result
