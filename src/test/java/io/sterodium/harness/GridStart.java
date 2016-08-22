package io.sterodium.harness;

public class GridStart {

    public static void main(String[] args) {
        SeleniumGridHarness harness = new SeleniumGridHarness();
        harness.startHub();
        harness.startNode();
    }

}
