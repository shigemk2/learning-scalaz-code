import Control.Applicative

main = do
    let f = (*) <$> (*2) <*> (+10)
    print $ f 3
