/*
 *  * @author kaboel
 *  * Muhammad Faiq Allam | faiq.kaboel@gmail.com
 */
package lds.lib.DAO;

import java.util.ArrayList;
import lds.lib.Entities.Transact;

/**
 *
 * @author kaboel
 */
public interface TrxDAO {
    ArrayList<Transact> getAllTrx();
    ArrayList<Transact> getTrxByStat(int stat);
    ArrayList<Transact> getTrxByOrig(int id_orig);
    ArrayList<Transact> getTrxByDest(int id_dest);
    ArrayList<Transact> getTrxByServ(int id_serv);
    boolean insertTrx(Transact trx);
}
