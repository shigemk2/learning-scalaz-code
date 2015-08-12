import Control.Applicative

just = do
    i <- Just "a"
    j <- Just "b"
    return $ i ++ j

main = do
    print $ just
