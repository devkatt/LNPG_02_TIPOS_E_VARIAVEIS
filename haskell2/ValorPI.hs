import Text.Printf

getPI :: Int -> Double
getPI length = cbrt $ 32 * agg
  where
    agg = sum [if even i then seq else -seq | i <- [0 .. length - 1]]
    seq = 1.0 / fromIntegral (value ^ 3)
    value = (i * 2) + 1

main :: IO ()
main = do
    putStrLn "Informe o número de termos: "
    length <- readLn :: IO Int
    printf "%.5f\n" (getPI length)
