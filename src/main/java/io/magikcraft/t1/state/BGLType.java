public class BGLType {
    //store the BGL internally as mmol/L
    private double bgl;
    private BGLMeasurementEnum bglm;
    //the conversion rate between mmol/l and mg/dL
    //1 mmol/L = 18 mg/dL
    private static final double conversionRate = 18.0;

    public BGLType(double initialBGL, BGLMeasurementEnum bglm )
    {
        this.bglm = bglm;
        setBGL(initialBGL);
    }

    public double getBGL()
    {
        switch (bglm) 
        {
            case mmolL: 
                return bgl;

            case mgdL: 
                return bgl * conversionRate;
        }
    }
    public setBGL(double newBGL)
    {
        switch (bglm) 
        {
            case mmolL: 
                this.bgl = newBGL;

            case mgdL: 
                this.bgl = newBGL / conversionRate;
        }
    }
}