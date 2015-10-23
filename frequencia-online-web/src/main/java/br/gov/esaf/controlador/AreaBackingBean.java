package br.gov.esaf.controlador;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.gov.esaf.aplicacao.AreaDao;
import br.gov.esaf.modelo.Area;

@Component("areaBB")
@Scope("request")
public class AreaBackingBean {

	private static final Logger logger = LoggerFactory.getLogger(AreaBackingBean.class);

	private Area area = new Area();
	private List<Area> areas;

	@Autowired
	private AreaDao areaDao;

	
	public String getMessage() {
		logger.debug("Returning message from area home bean");
		return "Hello from Spring";
	}	

	public Area getArea() {
		return area;
	}

	public void saveArea() {
		areaDao.save(area);
		area = new Area();
		invalidateAreas();
	}

	private void invalidateAreas() {
		areas = null;
	}

	public List<Area> getAreas() {
		if (areas == null) {
			areas = areaDao.list();
		}
		return areas;
		
	}
}
