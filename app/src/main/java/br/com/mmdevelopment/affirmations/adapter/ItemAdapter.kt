package br.com.mmdevelopment.affirmations.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.mmdevelopment.affirmations.R
import br.com.mmdevelopment.affirmations.model.Affirmation

/**
 * Adapter for Recycler View in Main Activity which displays Affirmation data object.
 */
class ItemAdapter(
    private val context: Context, private val dataSet: List<Affirmation>
) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    /**
     * Provides reference to the view for each data item. Each data item is an Affirmation object.
     */
    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.item_title)
        val imageView: ImageView = view.findViewById(R.id.item_image)
    }

    /**
     * Called by the layout manager to create new view holders for the RecyclerView (when there are
     * no existing view holders that can be reused).
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)
        return ItemViewHolder(adapterLayout)
    }

    /**
     * This method is called by the layout manager in order to replace the contents of a list item
     * view.
     */
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataSet[position]
        holder.textView.text = context.resources.getString(item.stringResourceId)
        holder.imageView.setImageResource(item.imageResourceId)
    }

    /**
     * Returns size of the dataset. Invoked by layout manager.
     */
    override fun getItemCount(): Int = dataSet.size
}