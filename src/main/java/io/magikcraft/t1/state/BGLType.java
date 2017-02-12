public class BGLType {
    //store the BGL internally as mmol/L
    private double bgl;
    //the conversion rate between mmol/l and mg/dL
    //1 mmol/L = 18 mg/dL
    private static final int conversionrate = 18;

    public BGLType()
    {}

    public double get_mmol_per_L()
    {
       return bgl;
    }
    public set_mmol_per_L(double newBGL)
    {
       this.bgl = newBGL;
    }

    public double get_mg_per_dL()
    {
        return bgl * conversionrate;
    }
    public get_mg_per_dL(double newBGL)
    {
       this.bgl = newBGL / conversionrate;
    }

}