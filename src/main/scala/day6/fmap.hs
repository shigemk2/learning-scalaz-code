main = do
    let f = (*5)
    let g = (+3)
    print $ (fmap f g) 8
