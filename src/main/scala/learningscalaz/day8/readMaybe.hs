import Control.Monad

readMaybe :: (Read a) => String -> Maybe a
readMaybe st = case reads st of [(x, "")] -> Just x
                                _ -> Nothing

-- main = do
    -- print $ readMaybe "1" :: Maybe Int
    -- print $ readMaybe "GOTO HELL" :: Maybe Int
