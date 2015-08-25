import Data.List

main = do
    print $ unfoldr (\b -> if b == 0 then Nothing else Just (b, b-1)) 10
