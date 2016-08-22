package io.sterodium.harness;

public class GridStart {

    public static void main(String[] args) throws Exception {
        SeleniumGridHarness harness = new SeleniumGridHarness();
        harness.hub().build();
        harness.node().build();
    }

}
