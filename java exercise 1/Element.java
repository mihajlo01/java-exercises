package naogjanjeElement;

public class Element {
	public int data;
	public Element levo,desno;
	
	public Element(int element) {
		data=element;
		levo=null;
		desno=null;
	}
	public void postaviDesno(Element e) {
		desno=e;
	}
	public void postaviLevo(Element e) {
		levo=e;
	}
	public Element zemiDesno() {
		return desno;
	}
	public Element zemiLevo() {
		return levo;
	}
	public int getData() {
		return data;
	}
	public void setData(int x) {
		data=x;
	}
	public static Element prebaraj(int kluc, Element e) {
		if(e==null||e.getData()==kluc) {
			return e;
			}
		else if(e.getData()>kluc)
			return prebaraj(kluc, e.zemiLevo());
		else
			return prebaraj(kluc, e.zemiDesno());
	}
	
	public static Element najdiMin(Element koren) {
		if(koren==null)
			return null;
		else if(koren.zemiLevo()!=null)
			return najdiMin(koren.zemiDesno());
		return koren;
	}
	
	public static Element vmetniElement(Element koren, int kluc) {
		if(koren==null)
			return new Element(kluc);
		else if(kluc>koren.getData())
			koren.postaviDesno(vmetniElement(koren.zemiDesno(),kluc));
		else
			koren.postaviLevo(vmetniElement(koren.zemiLevo(),kluc));
		return koren;
	}
	
	public static Element izbrisiElement(Element koren, int kluc) {
		if(koren==null)
			return null;
		if(kluc>koren.getData())
			koren.postaviDesno(izbrisiElement(koren.zemiDesno(),kluc));
		else if(kluc<koren.getData())
			koren.postaviLevo(izbrisiElement(koren.zemiLevo(),kluc));
		else
		{
			if(koren.zemiLevo()==null && koren.zemiDesno()==null) {
				koren=null;
				return null;
			}
			else if(koren.zemiLevo()==null || koren.zemiDesno()==null) {
				Element temp;
				if(koren.zemiLevo()==null)
					temp=koren.zemiDesno();
				else
					temp=koren.zemiLevo();
				koren=null;
				return temp;
			}
			else
			{
				Element temp=najdiMin(koren.zemiDesno());
				koren.setData(temp.getData());
				koren.postaviDesno(izbrisiElement(koren.zemiDesno(), temp.getData()));
			}
		}
		return koren;
	}
	
	public static void inorder(Element koren) {
		if(koren!=null) {
			inorder(koren.zemiLevo());
			System.out.println(" "+koren.getData()+" ");
			inorder(koren.zemiDesno());
		}
	}
public static void main(String[] args) {
	Element koren;
	koren=new Element(20);
	vmetniElement(koren,5);
	vmetniElement(koren,1);
	vmetniElement(koren,15);
	vmetniElement(koren,9);
	vmetniElement(koren,7);
	vmetniElement(koren,12);
	vmetniElement(koren,30);
	vmetniElement(koren,25);
	vmetniElement(koren,40);
	vmetniElement(koren,45);
	vmetniElement(koren,42);
	
	inorder(koren);
	
	if(prebaraj(40,koren) == null) {
		System.out.println("Klucot ne postoi vo drvoto!");
	}
	else {
		System.out.println("Klucot postoi vo drvoto!");
	}
	
	koren=izbrisiElement(koren,40);
	
	if(prebaraj(40,koren) == null) {
		System.out.println("Klucot ne postoi vo drvoto!");
	}
	else {
		System.out.println("Klucot postoi vo drvoto!");
	}
}
}
