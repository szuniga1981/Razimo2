package cl.sebastian.razimo2

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.room.*

@Entity(tableName="pojoRazimo")
data class Products(@PrimaryKey val id:Int, val name:String, val price:String, val images:Imagenes)
data class Imagenes(val src:String)

@Dao
interface  RazimoDao{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProducts(lista:List<Products>)

    @Query("SELECT * FROM pojoRazimo")
    fun getProducts():LiveData<List<Products>>

    @Query("SELECT * FROM pojoRazimo WHERE id=code")
    fun getProductsDetail (code: Int):LiveData<Products>
}

@Database(entities = [Products::class],version = 1)
abstract  class RazimoDatabase:RoomDatabase(){
    abstract fun razimoDao(): RazimoDao
}
class RazimoApplication:Application(){
    companion object{
        var razimoDatabase:RazimoDatabase?=null

    }

    override fun onCreate() {
        super.onCreate()
        razimoDatabase=Room.databaseBuilder(this,RazimoDatabase::class.java,"razimo_db").build()
    }
}