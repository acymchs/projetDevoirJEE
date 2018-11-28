package ig3.iscae.service;

import java.util.Map;

import ig3.iscae.memoire.Memoire;
import ig3.iscae.roles.DirecteurGeneral;

public class DGService {

	private Map<String, DirecteurGeneral> directeurs=Memoire.getDirecteurs();
	
}
