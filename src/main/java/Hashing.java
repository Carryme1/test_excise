public class Hashing {
    /*
     * uid/did 一致性hash算法
     */
	public static int consistentHash(long input, int buckets) {
        Hashing.LinearCongruentialGenerator generator = new Hashing.LinearCongruentialGenerator(input);
        int candidate = 0;

        while(true) {
            int next = (int)((double)(candidate + 1) / generator.nextDouble());
            if (next < 0 || next >= buckets) {
                return candidate;
            }

            candidate = next;
        }
    }

    private static final class LinearCongruentialGenerator {
        private long state;

        public LinearCongruentialGenerator(long seed) {
            this.state = seed;
        }

        public double nextDouble() {
            this.state = 2862933555777941757L * this.state + 1L;
            return (double)((int)(this.state >>> 33) + 1) / 2.147483648E9D;
        }
    }
    
    public static void main(String[] args) {
		int a = Hashing.consistentHash(101367, 1024);
		System.out.println(a);
		String did = "1df165f5265e5a083413dDwIq68kEANiastb";
		int b = Hashing.consistentHash(did.toLowerCase().hashCode(), 1024);
		System.out.println(b);
	}
}
