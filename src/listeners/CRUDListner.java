package listeners;

import com.app.entity.Stagiaire;

public interface CRUDListner {

	public void SearchPerformed(int stagiaire);

	public void addPerformed(Stagiaire stagiaire);

	public void modifyPerformed(int stagiaire, String[] tabContenu);

	public void removePerformed(int stagiaire);
}
