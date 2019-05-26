public class Lista{
	private int limit;
	private int size;
	private Castelo[] v;
	public Lista(){
		limit=1000;
		size=0;
		v = new Castelo[limit];
	}
	public Castelo get(int i){
		return v[i];
	}
	public void add(Castelo c){
		v[c.id] = c;
		size++;
	}
	public int size(){return size;}
}