gcd' :: Int -> Int -> Int
gcd' a b
    | b == 0 = a
    | otherwise = gcd' b (a `mod` b)

main = do
    print $ gcd' 8 3
    print $ gcd' 100 30
