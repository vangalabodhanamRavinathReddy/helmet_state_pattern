package helmet_state_pattern;


interface State 
{
    public void alert(Context ctx);
}
  
class Context 
{
    private State currentState;
  
    public Context() 
    {
        currentState = new StartProduction();
    }
  
    public void setState(State state) 
    {
        currentState = state;
    }
  
    public void alert() 
    {
        currentState.alert(this);
    }
}
  
class StartProduction implements State 
{
    @Override
    public void alert(Context ctx) 
    {
         System.out.println("Helmets production started...");
    }
  
}
  
class StopProduction implements State
{
    @Override
    public void alert(Context ctx) 
    {
        System.out.println("Helmets nail production stopped...");
    }
  
}
  
class StatePattern 
{
    public static void main(String[] args) 
    {
    	Context state = new Context();
    	state.alert();
    	state.setState(new StopProduction());
    	state.alert();     
    }
}