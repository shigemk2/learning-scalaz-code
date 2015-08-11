foo = do
    x <- Just 3
    y <- Just "!"
    Just (show x ++ y)

main = do
    print $ foo
