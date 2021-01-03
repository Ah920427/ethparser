package pro.belbix.ethparser.web3;

import java.math.BigInteger;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.DynamicStruct;

@SuppressWarnings("rawtypes")
public class DynamicStructures {

    //balancer
    public static class Swap extends DynamicStruct {

        public String pool;
        public BigInteger tokenInParam;
        public BigInteger tokenOutParam;
        public BigInteger maxPrice;

        public Swap(
            String pool,
            BigInteger tokenInParam,
            BigInteger tokenOutParam,
            BigInteger maxPrice
        ) {
            super(
                new org.web3j.abi.datatypes.Address(pool),
                new org.web3j.abi.datatypes.Uint(tokenInParam),
                new org.web3j.abi.datatypes.Uint(tokenOutParam),
                new org.web3j.abi.datatypes.Uint(maxPrice)
            );
            this.pool = pool;
            this.tokenInParam = tokenInParam;
            this.tokenOutParam = tokenOutParam;
            this.maxPrice = maxPrice;
        }

        public Swap(
            org.web3j.abi.datatypes.Address pool,
            org.web3j.abi.datatypes.Uint tokenInParam,
            org.web3j.abi.datatypes.Uint tokenOutParam,
            org.web3j.abi.datatypes.Uint maxPrice
        ) {
            super(
                pool,
                tokenInParam,
                tokenOutParam,
                maxPrice
            );
            this.pool = pool.getValue();
            this.tokenInParam = tokenInParam.getValue();
            this.tokenOutParam = tokenOutParam.getValue();
            this.maxPrice = maxPrice.getValue();
        }
    }

    public static TypeReference swapTypeReference() {
        return new TypeReference<Swap>() {
        };
    }

}
