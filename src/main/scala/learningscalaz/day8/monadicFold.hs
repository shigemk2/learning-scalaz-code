import Control.Monad

main = do
    let f = foldr (.) id [(+8),(*100),(+1)]
    print $ f 1
