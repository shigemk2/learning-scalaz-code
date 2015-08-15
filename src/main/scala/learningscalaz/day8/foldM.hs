import Control.Monad

binSmalls :: Int -> Int -> Maybe Int
binSmalls acc x
    | x > 9 = Nothing
    | otherwise = Just (acc + x)

main = do
    print $ foldM binSmalls 0 [2,8,3,1]
    print $ foldM binSmalls 0 [2,11,3,1]
