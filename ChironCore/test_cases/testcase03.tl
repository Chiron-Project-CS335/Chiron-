to add(:a, :b) [
  output :a + :b
] end

to multiply(:a, :b) [
  output :a * :b
] end

:result = add(5, multiply(3, 4))
forward :result
