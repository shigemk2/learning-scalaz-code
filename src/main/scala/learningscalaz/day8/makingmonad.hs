import Data.Ratio

newtype Prob a = Prob { getProb :: [(a, Rational)] } deriving Show

instance Functor Prob where
    fmap f (Prob xs) = Prob $ map (\(x, p) -> (f x, p)) xs

main = do
    print $ 1 % 4
    print $ 1 % 2 + 1 % 2
    print $ 1 % 3 + 5 % 4
    print $ [(3,1%2),(5,1%4),(9,1%4)]
    print $ fmap negate (Prob [(3,1%2),(5,1%4),(9,1%4)])
