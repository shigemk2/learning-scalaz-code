import Control.Applicative

main = do
    let f = (++) <$> Just "a" <*> Just "b"
    print $ f
