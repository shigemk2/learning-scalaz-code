import Control.Monad

main = do
    let f = (+1) . (*100)
    print $ f 4
    let g = (\x -> return (x+1)) <=< (\x -> return (x*100))
    print $ Just 4 >>= g
