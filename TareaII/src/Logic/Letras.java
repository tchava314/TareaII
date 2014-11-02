package Logic;

public class Letras<ele> implements Comparacion {
	private String palabra;

	public void Letras(ele palabra) {
		this.palabra = (String) palabra;
	}

	public Letras(ele ele) {
		palabra = (String) ele;
	}

	public String getPalabra() {
		return palabra;
	}

	public int Comparar(Comparacion obj) {
		if (((this.getPalabra().compareTo(((Letras) obj).getPalabra()))) > 0) {
			return 1;

		}
		if (((this.getPalabra().compareTo(((Letras) obj).getPalabra()))) == 0) {
			return 0;

		} else {
			return -1;
		}
	}
}
