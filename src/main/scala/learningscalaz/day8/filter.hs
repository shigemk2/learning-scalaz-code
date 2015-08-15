import Control.Monad.Writer

keepSmall :: Int -> Writer [String] Bool
keepSmall x
    | x < 4 = do
        tell ["Keeping " ++ show x]
        return True
    | otherwise = do
        tell [show x ++ " is too large, throwing it away"]
        return False

main = do
    print $ filter (\x -> x < 4) [9,1,5,2,10,3]
    print $ fst $ runWriter $ filterM keepSmall [9,1,5,2,10,3]
    mapM_ putStrLn $ snd $ runWriter $ filterM keepSmall [9,1,5,2,10,3]
